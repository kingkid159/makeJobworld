import requests
from bs4 import BeautifulSoup
import cx_Oracle
import os
conn=cx_Oracle.connect('job/job@localhost:1521/xe')
cur=conn.cursor()
sql="insert into educations values (eduno.nextval,'{}','{}','{}','{}','{}','{}','{}','{}','{}','{}','{}','{}','{}','{}')"
url="https://edu.incruit.com/list/lecturelist.asp?ct=10&fld=04&occ1=150&sup=3&sortfield=1&sortorder=1&blocksize=60"
result=requests.get(url)
dom=BeautifulSoup(result.text,'lxml')
# print(dom)
tr=dom.select('#incruit_contents div.edu_list_default > div.edu_list_table_a.edu_full_default > table > tbody > tr')
tempurl=[]
for a in tr:
    href=a.select_one('div.check_list_r > a')['href']
    tempurl.append(href)
#print(tempurl)
for turl in tempurl:
    result2=requests.get(turl)
    # print(result2)
    dom2=BeautifulSoup(result2.text,'lxml')
    title=dom2.select_one('h1 > strong').text
    #print(title)
    imgsrc=dom2.select_one('#corplogo')['src']
    imgsrc='https:'+imgsrc
    #print(imgsrc)
    acadamyname=dom2.select_one('div.jobpost_sider_cpinfo > p.brand_name').text
    #print(acadamyname)
    # acadamyurl=dom2.select_one('#incruit_contents div.jobpost_top_cpinfo_new_2017 div.jobpost_sider_cpinfo > p.brand_link > a')['href']
    # print(acadamyurl)
    eduphone=dom2.select_one('#incruit_contents div.joview_table > table > tbody > tr:nth-of-type(6) > td > p').text
    #print(eduphone)
    acadamyadd=dom2.select_one('div.jobpost_sider_cpinfo > div.jobpost_sider_cpinfo_table > dl:nth-of-type(1) > dd > p').text
    #print(acadamyadd)
    edufield=dom2.select_one('div.jobpost_sider_jbinfo > div:nth-of-type(1) > dl:nth-of-type(1) > dd > div > div').text
    edufield=edufield.replace('&gt ','')
    #print(edufield)
    # print('-'*30)
    edutype=dom2.select_one('div.jobpost_sider_jbinfo > div:nth-of-type(1) > dl:nth-of-type(2) > dd > div > div').text
    edutype=edutype.strip()
    #print(edutype)
    # print('-'*30)
    eduprocess=''
    # eduprocess=dom2.select_one('div.jobpost_sider_jbinfo > div:nth-of-type(1) > dl:nth-of-type(3) > dd > div > div').text
    # print(eduprocess,'모집과정')
    eduno=''
    # eduno=dom2.select_one('div.jobpost_sider_jbinfo > div:nth-of-type(1) > dl:nth-of-type(4) > dd > div > div').text
    # print(eduno.strip(),'수강인원')
    eduperiod=''
    # eduperiod=dom2.select_one('div.jobpost_sider_jbinfo > div:nth-of-type(1) > dl:nth-of-type(5) > dd > div > div').text
    # print(eduperiod.strip(),'교육기간')
    edulocation=dom2.select_one('#incruit_contents div.jobpost_top_cpinfo_new_2017 div.jobpost_sider_jbinfo dl:nth-of-type(6) > dd > div.inset_ely > div.inset_ely_lay > span.inblock')
    if type(edulocation)==type(None):
        eduprocess=' '
        #print(eduprocess)
        eduno=dom2.select_one('#incruit_contents div.jobpost_top_cpinfo_new_2017 div.jobpost_sider_jbinfo > div:nth-of-type(1) > dl:nth-of-type(3) div.inset_ely_lay').text
        eduno=eduno.strip()
        #print(eduno)
        eduperiod=dom2.select_one('#incruit_contents div.jobpost_top_cpinfo_new_2017 div.jobpost_sider_jbinfo > div:nth-of-type(1) > dl:nth-of-type(4) div.inset_ely_lay.letter_0').text
        eduperiod=eduperiod.strip()
        #print(eduperiod)
        edulocation=dom2.select_one('#incruit_contents div.jobpost_top_cpinfo_new_2017 div.jobpost_sider_jbinfo > div:nth-of-type(1) > dl:nth-of-type(5) span.inblock').text
        #print(edulocation)
        eduprice=dom2.select_one('div.jobpost_sider_jbinfo_inlay.jobpost_sider_jbinfo_inlay_last > dl:nth-of-type(1) div.inset_ely > div.inset_ely_lay > em.pt_txt.pt_txt_free').text
        #print(eduprice)
        eduplus=' '
        #print(eduplus)
        eduapp=dom2.select_one('div.jobpost_sider_jbinfo_inlay.jobpost_sider_jbinfo_inlay_last > dl:nth-of-type(2) div.inset_ely > div.inset_ely_lay > em.pt_txt.letter_0').text
        #print(eduapp)
    else:
        eduprocess = dom2.select_one(
            'div.jobpost_sider_jbinfo > div:nth-of-type(1) > dl:nth-of-type(3) > dd > div > div').text
        # print(eduprocess)
        eduprocess = dom2.select_one(
            'div.jobpost_sider_jbinfo > div:nth-of-type(1) > dl:nth-of-type(3) > dd > div > div').text
        #print(eduprocess)
        eduno = dom2.select_one(
            'div.jobpost_sider_jbinfo > div:nth-of-type(1) > dl:nth-of-type(4) > dd > div > div').text
        eduno=eduno.strip()
        #print(eduno.strip())
        eduperiod = dom2.select_one(
            'div.jobpost_sider_jbinfo > div:nth-of-type(1) > dl:nth-of-type(5) > dd > div > div').text
        eduperiod=eduperiod.strip()
        #print(eduperiod.strip())
        edulocation = dom2.select_one(
            '#incruit_contents div.jobpost_top_cpinfo_new_2017 div.jobpost_sider_jbinfo dl:nth-of-type(6) > dd > div.inset_ely > div.inset_ely_lay > span.inblock')
        edulocation=dom2.select_one('#incruit_contents div.jobpost_top_cpinfo_new_2017 div.jobpost_sider_jbinfo dl:nth-of-type(6) > dd > div.inset_ely > div.inset_ely_lay > span.inblock').text
        edulocation=edulocation.replace(',','')
        # print(edulocation)
        eduprice=dom2.select_one('#incruit_contents div.jobpost_sider_jbinfo_inlay.jobpost_sider_jbinfo_inlay_last div.inset_ely em').text
        # print(eduprice)
        eduplus=dom2.select_one('#incruit_contents div.jobpost_sider_jbinfo_inlay.jobpost_sider_jbinfo_inlay_last > dl:nth-of-type(2) div.inset_ely_lay').text
        eduplus=eduplus.strip()
        # print(eduplus.strip())
        eduapp=dom2.select_one('#incruit_contents div.jobpost_sider_jbinfo div.jobpost_sider_jbinfo_inlay.jobpost_sider_jbinfo_inlay_last em.pt_txt.letter_0').text
        # print(eduapp)
    # print('제목:{}\n이미지경로:{}\n학원명:{}\n문의 전화번호:{}\n학원주소:{}\n교육분야:{}\n교육형태:{}\n모집과정:{}\n모집인원:{}\n교육기간:{}\n교육지역:{}\n교육비용:{}\n수강특전:{}\n접수기간:{}\n'.format(title,imgsrc,acadamyname,eduphone,acadamyadd,edufield,edutype,eduprocess,eduno,eduperiod,edulocation,eduprice,eduplus,eduapp))
    cur.execute(sql.format(title, imgsrc, acadamyname, eduphone, acadamyadd, edufield, edutype, eduprocess, eduno, eduperiod, edulocation, eduprice, eduplus, eduapp))
conn.commit()
conn.close()
