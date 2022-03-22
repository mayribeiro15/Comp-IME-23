from requests import get
from bs4 import BeautifulSoup

url = 'https://www.robocup.org/'
response = get(url)

soup = BeautifulSoup(response.text, 'html.parser')

newsTitlesHtml = soup.findAll(class_='gdlr-blog-title')
newsTitles = []

for i in range (0,len(newsTitlesHtml)):
    newsTitles.append(newsTitlesHtml[i].a.text)

print("ROBOCUP 2022")
print("Main Page News Headlines:")
print(*newsTitles, sep="\n")