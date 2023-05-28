from PIL import Image
import cv2 
import numpy as np
import colorsys

# Criando a imagem
width = 500
height = 500
image = Image.new(mode="RGB", size=(width, height), color=(0,0,0))

# Posicionamento
camera = np.array([0,0,-500]) 
screen = np.array([-width/2, -height/2, -200])  
light_source = np.array([0,-1000,0]) 

# Parâmetros de cor
light_color = np.array([255,255,255]) 
light_intensity = 1
env_color = np.array([255,0,255]) 
env_intensity = 0.3

# Projetando a esfera
sphere = {'center': np.array([0,0,0]), 'radius': 250 }

def normalize(v):
    norm = np.linalg.norm(v)
    if norm == 0: 
       return v
    return v/norm

def ray_casting(sphere, pixel):
        v = normalize(np.subtract(pixel,camera))
        pos = np.subtract(camera,sphere['center'])
        
        delta = np.dot(v,pos)**2 - (np.dot(pos,pos) - sphere['radius']**2 )
        
        if delta < 0: 
            return False
        elif delta == 0:
            t = -np.dot(v,pos) 
            if t >= 0:
                return np.add(camera,v*t).tolist()
            else:
                return False
        else:
            t1 = -np.sqrt(delta) -np.dot(v,pos)
            t2 = np.sqrt(delta) -np.dot(v,pos)
                        
            if min(t1, t2) >= 0:
                return np.add(camera,v*min(t1, t2)).tolist()
            elif max(t1, t2) >= 0:
                return np.add(camera,v*max(t1, t2)).tolist()
            else:
                return False

for i in range(width):
    for j in range(height):
        pixel = np.add(screen,[i,j,0]) 
        I = np.array([0, 0, 0])
        
        point = ray_casting(sphere,pixel)
        
        if point != False:
            point = np.array(point)
            
            # Componentes
            N = normalize(np.subtract(point,sphere['center'])) #direção normal
            L = normalize(np.subtract(light_source,point)) #luz incidente
            R = np.subtract((2*np.dot(L,N))*N,L) #luz refletida
            V = normalize(np.subtract(camera,point)) #direção observador
            
            # Produtos escalares
            NL = np.dot(N,L) 
            VR = np.dot(V,R) 
            
            # Reflexão de Phong
            Ii = light_color*light_intensity
            
            # componente difusa
            kd = [1, 0, 1]
            Id = (kd[0]*NL*Ii[0], kd[1]*NL*Ii[1], kd[2]*NL*Ii[2])
            
            # componente especular
            n = 10
            ks = 1 # zero no modelo lambertiano
            Is = ks*(VR**n)*Ii 
            
            # luz ambiente
            Iamb = env_color*env_intensity
            
            if (NL >= 0):
                if (VR >= 0):
                    I = np.add(Id,Is)
                else:
                    I = Id
            I = np.add(I,Iamb) 
            
        image.putpixel([i, j], (int(I[0]),int(I[1]),int(I[2])))

image.show()
image.save("phong1.jpg")
            
            