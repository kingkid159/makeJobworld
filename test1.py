import pandas as pd
import matplotlib.pyplot as plt
from matplotlib import font_manager,rc
import numpy as np
fname=font_manager.FontProperties(fname='C:\Windows\Fonts\malgun.ttf').get_name()
rc('font',family=fname)
df=pd.read_csv('data\job.csv',sep='::')
df1=pd.read_csv('data\job1 (1).csv',sep='::')
dfAll=pd.concat([df,df1])
# pd.set_option('display.max_row', 1000)
# pd.set_option('display.max_columns', 20)
print(dfAll)
print('------------------------------------------------------------------')

# print(df[df['경력,학력'].str.contains('대졸')].count())
# print(df[df['근무지,근무형태'].str.contains('서울')].count())

# pivo=pd.pivot_table(df,index='분류코드',aggfunc=['count'])
# print(pivo.index)
# print(pivo.values)
# plt.bar(pivo,pivo.index,pivo.values)

def getJob(x):
    if x==17111 or x==16187 or x==16765 or x==16766 or x==14690:
        return '웹프로그래머'
    elif x==16883 or x==14620 or x==16617 or x==16941 or x==16942:
        return '퍼블리싱UI개발'
    elif x==14860 or x==13630 or x==12000 or x==16993 or x==16903:
        return 'ERP,시스템분석,설계'
    elif x==16935 or x==16182 or x==14940 or x==14810 or x==14780:
        return '데이터베이스,DBA'
    else:
        return '빅데이터AI'
def getCodeName(x):
    if x==17111:
        return '웹개발'
    elif x==16187:
        return '자바'
    elif x==16765:
        return '백엔드'
    elif x==16766:
        return '프론트'
    elif x==14690:
        return 'jsp'
    elif x== 16883:
        return 'css'
    elif x== 14620:
        return '퍼블리셔'
    elif x==16617:
        return '웹표준'
    elif x==16941:
        return '자바스크립'
    elif x==16942:
        return 'xml'
    elif x==16981:
        return '데이터분석'
    elif x==16980:
        return '인공지능'
    elif x==16979:
        return '빅데이터'
    elif x==16982:
        return '파이썬'
    else:
        return '머신러닝'
def getSalary(x):
    if x=='None':
        return np.nan
    x=x.replace(',','')
    x=int(x)
    if x<2500:
        return '2500미만'
    elif 2500<=x<3000:
        return '2500이상3000미만'
    elif 3000<=x<4000:
        return '3000이상4000미만'
    elif 4000<=x<5000:
        return '4000이상5000미만'
    else:
        return '5000이상'

        # 웹개발 = 17111, 자바 = 16187, 백엔드 = 16765, 프론트 = 16766, jsp = 14690
    # css = 16883, 퍼블리셔 = 14620, 웹표준 = 16617, 자바스크립 = 16941, xml = 16942
    # 데이터분석 = 16981, 인공지능 = 16980, 빅데이터 = 16979, 파이썬 = 16982, 머신러닝 = 16983
dfAll['직종명']=dfAll['분류코드'].apply(getJob)
df['분류명']=df['분류코드'].apply(getCodeName)
df['직종명']=df['분류코드'].apply(getJob)
print(df)
# 직종별 채용공고 통계
dfg=dfAll.groupby(['직종명'])
dfg=dfg['기업명'].count()

# print(dfg)
# print(dfg.values)
# print(dfg.index)
# plt.bar(dfg.index,dfg.values) #막대그래프
# # plt.plot(dfg) #꺾은선 그래프
# plt.show()
job=['웹프로그래머','퍼블리싱UI개발','ERP,시스템분석,설계','데이터베이스,DBA','빅데이터AI']
# 직무별 채용공고 통계 1.웹프로그래머
dfW=df[df['직종명']=='웹프로그래머']
dfWG=dfW.groupby('분류명')
dfWG=dfWG['기업명'].count()
# print(dfWG.values)
# plt.bar(dfWG.index,dfWG.values) #막대그래프
# plt.show()
# 직무별 채용공고 통계 2. 퍼블리싱UI개발
dfW=df[df['직종명']=='퍼블리싱UI개발']
dfWG=dfW.groupby('분류명')
dfWG=dfWG['기업명'].count()
# print(dfWG.values)
# plt.bar(dfWG.index,dfWG.values) #막대그래프
# plt.show()
# 직무별 채용공고 통계 3. 빅데이터AI
dfW=df[df['직종명']=='빅데이터AI']
dfWG=dfW.groupby('분류명')
dfWG=dfWG['기업명'].count()
# plt.bar(dfWG.index,dfWG.values) #막대그래프
# plt.show()
# 평균연봉 그래프
df['연봉구분']=df['평균연봉'].apply(getSalary)
df=df[df['분류명']=='자바']
dfS=df.groupby('연봉구분')['기업명'].count()
# plt.bar(dfS.index,dfS.values)
# plt.show()
# 경력별 그래프
dfN=df[df['경력,학력'].str.contains('신입')].count()
print(dfN)
dfO=df[df['경력,학력'].str.contains('경력')].count()
print(dfO)
career=pd.DataFrame({'신입':dfN,'경력':dfO})
careerV=career.values[1]
# plt.pie(careerV,labels=['신입','경력'],autopct='%.1f%%')
# plt.show()
# 근무형태 그래프
dfN=df[df['근무지,근무형태'].str.contains('정규직')].count()
print(dfN)
dfO=df[df['근무지,근무형태'].str.contains('계약직')].count()
print(dfO)
career=pd.DataFrame({'정규직':dfN,'계약직':dfO})
careerV=career.values[1]
# plt.pie(careerV,labels=['정규직','계약직'],autopct='%.1f%%')
# plt.show()
# print(career)
# 학력별 그래프
dfU=df[df['경력,학력'].str.contains('초대졸')==False]
dfU=dfU[dfU['경력,학력'].str.contains('대졸')].count()
dfH=df[df['경력,학력'].str.contains('고졸')].count()
dfA=df[df['경력,학력'].str.contains('학력무관')].count()
dfB=df[df['경력,학력'].str.contains('초대졸')].count()
dfE=pd.DataFrame({'학력무관':dfA,'고졸':dfH,'대졸':dfU,'초대졸':dfB})
dfEV=dfE.values[1]
# plt.bar(dfE.columns,dfEV)
# plt.show()
# 근무지
dfSeoul=df[df['근무지,근무형태'].str.contains('서울')].count()
dfGyeonggi=df[df['근무지,근무형태'].str.contains('경기')].count()
dfChungbuk=df[df['근무지,근무형태'].str.contains('충북')].count()
dfChungnam=df[df['근무지,근무형태'].str.contains('충남')].count()
dfGangwon=df[df['근무지,근무형태'].str.contains('강원')].count()
dfJeonnam=df[df['근무지,근무형태'].str.contains('전남')].count()
dfJeonbuk=df[df['근무지,근무형태'].str.contains('전북')].count()
dfGyeongbuk=df[df['근무지,근무형태'].str.contains('경북')].count()
dfGyeongnam=df[df['근무지,근무형태'].str.contains('경남')].count()
dfJeju=df[df['근무지,근무형태'].str.contains('제주')].count()
dfGwangju=df[df['근무지,근무형태'].str.contains('광주')].count()
dfBusan=df[df['근무지,근무형태'].str.contains('부산')].count()
dfDaejeon=df[df['근무지,근무형태'].str.contains('대전')].count()
dfIncheon=df[df['근무지,근무형태'].str.contains('인천')].count()
dfDaegu=df[df['근무지,근무형태'].str.contains('대구')].count()
dfUlsan=df[df['근무지,근무형태'].str.contains('울산')].count()
dfCity=pd.DataFrame({'서울':dfSeoul,'경기':dfGyeonggi,'인천':dfIncheon,
                     '충북':dfChungbuk,'충남':dfChungnam,'대전':dfDaejeon,'강원':dfGangwon,
                     '전북':dfJeonbuk,'전남':dfJeonnam,'광주':dfGwangju,
                     '경북':dfGyeongbuk,'경남':dfGyeongnam,'대구':dfDaegu,
                     '울산':dfUlsan,'부산':dfBusan,'제주':dfJeju}
                     )
# print(dfCity)
# plt.bar(dfCity.columns,dfCity.values[1])
# plt.show()
# plt.pie(dfCity.values[1],labels=dfCity.columns,autopct='%.1f%%')
# plt.show()
# 기업규모
big=df[df['기업규모']=='대기업'].count()
medium=df[df['기업규모']=='중견기업'].count()
smallmedium=df[df['기업규모']=='중소기업'].count()
small=df[df['기업규모']=='소기업'].count()
dfSize=pd.DataFrame({'대기업':big,'중견기업':medium,'중소기업':smallmedium,'소기업':small})
plt.bar(dfSize.columns,dfSize.values[1])
plt.show()
plt.pie(dfSize.values[1],labels=dfSize.columns,autopct='%.1f%%')
plt.show()
