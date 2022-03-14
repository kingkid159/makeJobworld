import requests
from bs4 import BeautifulSoup
import time
# 웹개발 = 17111, 자바 = 16187, 백엔드 = 16765, 프론트 = 16766, jsp = 14690
# css = 16883, 퍼블리셔 = 14620, 웹표준 = 16617, 자바스크립 = 16941, xml = 16942
# 데이터분석 = 16981, 인공지능 = 16980, 빅데이터 = 16979, 파이썬 = 16982, 머신러닝 = 16983
a=[17111,16187,16765,16766,14690,16883,14620,16617,16941,16942,16981,16980,16979,16982,16983]
c=0
with open('data\job1.csv','w',encoding='utf-8')as file:
    for a in a:
        for b in range(1,30,1):
            url='https://job.incruit.com/jobdb_list/searchjob.asp?occ3={}&page={}'.format(a,b)
            result=requests.get(url)
            dom=BeautifulSoup(result.text,'lxml')
            tr=dom.select('#incruit_contents > div.section_layout > div.n_job_list_default > div.n_job_list_table_a.list_full_default > table > tbody > tr')
            for i in tr:
                # link=회사정보링크, linkH=채용정보링크, company=회사명, title=채용공고제목, certify=지원자격, term=근무조건
                # size=회사규모, logo=회사로고, linkS= 회사급여정보, avgS=평균연봉, monthS=평균월급, welfare=복리후생
                c = c + 1
                print(c)
                print('직종 유형번호 {}'.format(a))
                try:
                    company=i.select_one('a.strong').text
                except AttributeError:
                    try:
                        company=i.select_one('span.noneLink').text
                    except AttributeError:
                        company = None
                        break
                else:
                    print('회사명 : ', company)
                title=i.select_one('a.links').text
                certify=i.select_one('div.subjects.termArea > p.details_txts > em').text
                term=i.select_one('td:nth-child(4) > div > p > em').text
                term=term.replace('\r\n','\t')
                # print(term)
                term=term.strip()
                term=term.replace('','')
                linkH=i.select_one('a.links')['href']
                # certify=certify.split('년')
                # print(linkH)
                # print(link)
                print('채용공고제목 : ',title)
                print('경력 및 학력 : ',certify)
                print('조건 : (수정필요)',term)
                try:
                    link = i.select_one('a.strong')['href']
                except TypeError:
                    link=None
                else:
                    result=requests.get(link)
                    dom=BeautifulSoup(result.text,'lxml')
                try:
                    size=dom.select_one('#company_warp > div:nth-child(1) > div > div > div > div > div > div > ul:nth-child(1) > li:nth-child(2) > span > a').text
                except AttributeError:
                    size=None
                else:
                    print('기업규모 : ',size)
                if (link!=None):
                    linkS=link+'/salary/'
                resultS=requests.get(linkS)
                domS=BeautifulSoup(resultS.text,'lxml')
                try:
                    avgS = domS.select_one(
                        '#salarySection > div.pay_money > div:nth-child(2) > p.money > strong').text
                except AttributeError:
                    avgS=None
                    print('평균연봉 : ',avgS)
                else:
                    # avgS = avgS.replace('자세히보기', '')
                    print('평균연봉 : ',avgS)
                file.write('{}::{}::{}::{}::{}::{}\n'.format(company,certify,term,size,avgS,a))
            time.sleep(2)
            if(company==None):
                break
        # if(company==None):
        #     break
            # link=회사정보링크, linkH=채용정보링크, company=회사명, title=채용공고제목, certify=지원자격, term=근무조건
            # size=회사규모, logo=회사로고, linkS= 회사급여정보, avgS=평균연봉, monthS=평균월급, welfare=복리후생
            # break

