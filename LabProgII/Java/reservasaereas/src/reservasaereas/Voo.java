package reservasaereas;

public class Voo {
	private int id;
	private String numeroVoo;
	private String aeroportoOrigem;
	private String aeroportoDestino;
	private double distanciaKm;
    private String modeloAviao;
    private int totalPoltronas;
    private int poltronasVagas;
    private String numeroAutorizacaoAnac;
    
    public Voo() {}
	
	public Voo(String numeroVoo, String aeroportoOrigem, String aeroportoDestino, double distanciaKm, String modeloAviao, int totalPoltronas, String numeroAutorizacaoAnac) {
		this.numeroVoo = numeroVoo;
		this.aeroportoOrigem = aeroportoOrigem;
		this.aeroportoDestino = aeroportoDestino;
		this.distanciaKm = distanciaKm;
		this.modeloAviao = modeloAviao;
		this.totalPoltronas = totalPoltronas;
		this.poltronasVagas = totalPoltronas;
		this.numeroAutorizacaoAnac = numeroAutorizacaoAnac;
	}
	
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
	
    public String getNumeroVoo() {
        return numeroVoo;
    }
    
    public void setNumeroVoo(String numeroVoo) {
        this.numeroVoo = numeroVoo;
    }
    
    public String getAeroportoOrigem() {
        return aeroportoOrigem;
    }
    
    public void setAeroportoOrigem(String aeroportoOrigem) {
        this.aeroportoOrigem = aeroportoOrigem;
    }
    
    public String getAeroportoDestino() {
        return aeroportoDestino;
    }
    
    public void setAeroportoDestino(String aeroportoDestino) {
        this.aeroportoDestino = aeroportoDestino;
    }
    
    public double getDistanciaKm() {
        return distanciaKm;
    }
    
    public void setDistanciaKm(double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }
  
    public String getModeloAviao() {
        return modeloAviao;
    }
    
    public void setModeloAviao(String modeloAviao) {
        this.modeloAviao = modeloAviao;
    }
    
    public int getTotalPoltronas() {
        return totalPoltronas;
    }
    
    public int getPoltronasVagas() {
        return poltronasVagas;
    }
    
    public void setTotalPoltronas(int totalPoltronas) {
        this.totalPoltronas = totalPoltronas;
    }
    
    public void setPoltronasVagas(int poltronasVagas) {
        this.poltronasVagas = poltronasVagas;
    }
    
    public String getNumeroAutorizacaoAnac() {
        return numeroAutorizacaoAnac;
    }
    
    public void setNumeroAutorizacaoAnac(String numeroAutorizacaoAnac) {
        this.numeroAutorizacaoAnac = numeroAutorizacaoAnac;
    }
}
