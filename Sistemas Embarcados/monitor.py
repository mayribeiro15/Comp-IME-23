import requests
import os
from bs4 import BeautifulSoup
import chrome_local_storage

local_storage = chrome_local_storage.ChromeLocalStorage()

local_storage.set('https://meet.google.com/nww-fgjy-ybm', 'my-key', 'my-value')
value = local_storage.get('example.com', 'my-key')
print(value)

# URL_TO_MONITOR = "https://meet.google.com/nww-fgjy-ybm" #change this to the URL you want to monitor

# def process_html(string):
#     soup = BeautifulSoup(string, features="lxml")
#     # make the html look good
#     soup.prettify()
#     # remove script tags
#     for s in soup.select('script'):
#         s.extract()
#     # remove meta tags 
#     for s in soup.select('meta'):
#         s.extract()
#     # convert to a string, remove '\r', and return
#     return str(soup).replace('\r', '')

# def webpage_was_changed(word): 
#     """Returns true if the webpage was changed, otherwise false."""
#     headers = {'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36',
#     'Pragma': 'no-cache', 'Cache-Control': 'no-cache'}
#     response = requests.get(URL_TO_MONITOR, headers=headers)
    
#     filehandle = open("previous_content.txt", 'r')
#     previous_response_html = filehandle.read() 
#     filehandle.close()
    
#     processed_response_html = process_html(response.text)

#     if processed_response_html == previous_response_html:
#         return False
#     else:
#         if(processed_response_html.find(word)!=-1):
#             return True
#         filehandle = open("previous_content.txt", 'w')
#         filehandle.write(processed_response_html)
#         filehandle.close()
#         return True
    
# while(1):
#     if webpage_was_changed("mayarinha"):
#         print("mudou")