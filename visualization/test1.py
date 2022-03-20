import pandas as pd
import matplotlib.pyplot as plt
from matplotlib import font_manager,rc
import numpy as np
from wordcloud import WordCloud
fname=font_manager.FontProperties(fname='C:\Windows\Fonts\malgun.ttf').get_name()
rc('font',family=fname)
df=pd.read_csv('data\job.csv',sep='::').drop_duplicates()
df1=pd.read_csv('data\job1 (1).csv',sep='::')
dfAll=pd.concat([df,df1]).drop_duplicates()
pd.set_option('display.max_row', 1000)
pd.set_option('display.max_columns', 20)
# print(dfAll)
# print('------------------------------------------------------------------')

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
def getCity(x):
    if x.find('서울')!=-1:
        return '서울 '
    elif x.find('충북')!=-1:
        return '충북 '
    elif x.find('경기')!=-1:
        return '경기 '
    elif x.find('충남')!=-1:
        return '충남 '
    elif x.find('강원')!=-1:
        return '강원 '
    elif x.find('전남')!=-1:
        return '전남 '
    elif x.find('전북')!=-1:
        return '전북 '
    elif x.find('경북')!=-1:
        return '경북 '
    elif x.find('경남')!=-1:
        return '경남 '
    elif x.find('제주')!=-1:
        return '제주 '
    elif x.find('광주')!=-1:
        return '광주 '
    elif x.find('부산')!=-1:
        return '부산 '
    elif x.find('대전')!=-1:
        return '대전 '
    elif x.find('인천')!=-1:
        return '인천 '
    elif x.find('대구')!=-1:
        return '대구 '
    else:
        return '울산 '

dfAll['직종명']=dfAll['분류코드'].apply(getJob)
df['분류명']=df['분류코드'].apply(getCodeName)
df['직종명']=df['분류코드'].apply(getJob)
# print(df)
print('dffffffffffffffffffffffffffffffffffffffffffffffffff')
df['연봉수준']=df['평균연봉'].apply(getSalary)
# print(df)
dfSSpivot=pd.pivot_table(df,index='기업규모',columns='연봉수준',values='기업명',aggfunc=['count'])
# print(dfSSpivot)
noSal=df[df['평균연봉']=='None']
bigNoSal=noSal[noSal['기업규모']=='대기업'].count()
# print(noSal)
noSalG=noSal.groupby('기업규모').count()
# print(noSalG)
# 직종별 채용공고 통계
dfg=dfAll.groupby(['직종명'])
dfg=dfg['기업명'].count()
text=''.join(dfAll['직종명'])
# print(text)
wordCloud = WordCloud(background_color='white',font_path='C:\Windows\Fonts\malgun.ttf')
wordCloud.generate(text)
plt.imshow(wordCloud)
plt.axis('off')
# plt.show()
# print(dfg)
# print(dfg.values)
# print(dfg.index)
# plt.figure(figsize=(9, 5))
# plt.bar(dfg.index,dfg.values) #막대그래프
# # plt.plot(dfg) #꺾은선 그래프
# plt.show()
occupation=['웹프로그래머','퍼블리싱UI개발','빅데이터AI']
# 직무별 채용공고 통계

for o in occupation:
    dfW=df[df['직종명']=='{}'.format(o)]
    dfWG=dfW.groupby('분류명')
    dfWG=dfWG['기업명'].count()
    # print(dfWG.values)
    # plt.figure(figsize=(9, 5))
    # plt.bar(dfWG.index,dfWG.values) #막대그래프
    # plt.title('{} 세부직무 채용현황'.format(o))
    # plt.show()
    # plt.savefig('data\{}_막대그래프.png'.format(o))
    # plt.close()
job=[['웹개발', '자바', '백엔드', '프론트', 'jsp'], ['css', '퍼블리셔', '웹표준', '자바스크립', 'xml'], ['데이터분석',
     '인공지능','빅데이터','파이썬','머신러닝']]
# 평균연봉 그래프
# df=df.dropna
df['연봉구분']=df['평균연봉'].apply(getSalary)
x=0
y=0
for o in occupation:
    # print(o)
    dfW = df[df['직종명']=='{}'.format(o)]
    # print('dfW=',dfW)
    # print(y)
    jobb = job[y]
    # print('job=',jobb)
    for j in jobb:
        # 평균연봉 그래프
        dff = dfW[dfW['분류명'] == '{}'.format(j)]
        x=x+1
        dfSSpivot=pd.pivot_table(dff,index='기업규모',columns='연봉수준',values='기업명',aggfunc=['count'])
        print('sal')
        print(dfSSpivot)
        print('salvalue')
        print(dfSSpivot.values)
        dfSSpivotV=dfSSpivot.values
        for dSPV in dfSSpivotV:
            print(dSPV.sum)
        noSal=dff[dff['평균연봉']=='None']
        bigNoSal=noSal[noSal['기업규모']=='대기업'].count()
        # print(noSal)
        noSalG=noSal.groupby('기업규모').count()
        print('noSal')
        print(noSalG)
        # dff=dfW[dfW['분류명']=='{}'.format(j)]
        dfS=dff.groupby('연봉구분')['기업명'].count()
        plt.figure(figsize=(9, 5))
        plt.bar(dfS.index,dfS.values)
        plt.title('{} 평균연봉'.format(j))
        plt.show()
        # plt.savefig('data\{}_{}_평균연봉.png'.format(o, j))
        plt.close()
        break
        # 경력별 그래프
        dfN=dff[dff['경력,학력'].str.contains('신입')].count()
        dfO=dff[dff['경력,학력'].str.contains('경력')].count()
        career=pd.DataFrame({'신입':dfN,'경력':dfO})
        careerV=career.values[1]
        plt.pie(careerV,labels=['신입','경력'],autopct='%.1f%%')
        plt.title('{} 신입,경력'.format(j))
        # plt.show()
        plt.savefig('data\{}_{}_경력별.png'.format(o,j))
        plt.close()
        # 근무형태 그래프
        dfN=dff[dff['근무지,근무형태'].str.contains('정규직')].count()
        dfO=dff[dff['근무지,근무형태'].str.contains('계약직')].count()
        career=pd.DataFrame({'정규직':dfN,'계약직':dfO})
        careerV=career.values[1]
        plt.pie(careerV,labels=['정규직','계약직'],autopct='%.1f%%')
        plt.title('{} 근무형태'.format(j))
        plt.savefig('data\{}_{}_근무형태.png'.format(o, j))
        plt.close()
        # plt.show()
        # 학력별 그래프
        dfU=dff[dff['경력,학력'].str.contains('초대졸')==False]
        dfU=dfU[dfU['경력,학력'].str.contains('대졸')].count()
        dfH=dff[dff['경력,학력'].str.contains('고졸')].count()
        dfA=dff[dff['경력,학력'].str.contains('학력무관')].count()
        dfB=dff[dff['경력,학력'].str.contains('초대졸')].count()
        dfE=pd.DataFrame({'학력무관':dfA,'고졸':dfH,'대졸':dfU,'초대졸':dfB})
        dfEV=dfE.values[1]
        plt.bar(dfE.columns,dfEV)
        plt.title('{} 학력별'.format(j))
        plt.savefig('data\{}_{}_학력별.png'.format(o, j))
        plt.close()
        # plt.show()
        # 근무지
        dfSeoul=dff[dff['근무지,근무형태'].str.contains('서울')].count()
        dfGyeonggi=dff[dff['근무지,근무형태'].str.contains('경기')].count()
        dfChungbuk=dff[dff['근무지,근무형태'].str.contains('충북')].count()
        dfChungnam=dff[dff['근무지,근무형태'].str.contains('충남')].count()
        dfGangwon=dff[dff['근무지,근무형태'].str.contains('강원')].count()
        dfJeonnam=dff[dff['근무지,근무형태'].str.contains('전남')].count()
        dfJeonbuk=dff[dff['근무지,근무형태'].str.contains('전북')].count()
        dfGyeongbuk=dff[dff['근무지,근무형태'].str.contains('경북')].count()
        dfGyeongnam=dff[dff['근무지,근무형태'].str.contains('경남')].count()
        dfJeju=dff[dff['근무지,근무형태'].str.contains('제주')].count()
        dfGwangju=dff[dff['근무지,근무형태'].str.contains('광주')].count()
        dfBusan=dff[dff['근무지,근무형태'].str.contains('부산')].count()
        dfDaejeon=dff[dff['근무지,근무형태'].str.contains('대전')].count()
        dfIncheon=dff[dff['근무지,근무형태'].str.contains('인천')].count()
        dfDaegu=dff[dff['근무지,근무형태'].str.contains('대구')].count()
        dfUlsan=dff[dff['근무지,근무형태'].str.contains('울산')].count()
        dfCity=pd.DataFrame({'서울':dfSeoul,'경기':dfGyeonggi,'인천':dfIncheon,
                             '충북':dfChungbuk,'충남':dfChungnam,'대전':dfDaejeon,'강원':dfGangwon,
                             '전북':dfJeonbuk,'전남':dfJeonnam,'광주':dfGwangju,
                             '경북':dfGyeongbuk,'경남':dfGyeongnam,'대구':dfDaegu,
                             '울산':dfUlsan,'부산':dfBusan,'제주':dfJeju}
                             )
        dff['지역명']=dff['근무지,근무형태'].apply(getCity)
        # print(dff)
        text=''.join(dff['지역명'])
        # print(text)
        wordCloud = WordCloud(background_color='white',font_path='C:\Windows\Fonts\malgun.ttf')
        wordCloud.generate(text)
        plt.imshow(wordCloud)
        plt.axis('off')
        plt.title('{}_지역별 워드클라우드'.format(j))
        plt.savefig('data\{}_{}_지역별워드클라우드'.format(o,j))
        # plt.show()
        # plt.bar(dfCity.columns,dfCity.values[1])
        # plt.show()
        # plt.pie(dfCity.values[1],labels=dfCity.columns,autopct='%.1f%%')
        # plt.show()
        # 기업규모
        big=dff[dff['기업규모']=='대기업'].count()
        medium=dff[dff['기업규모']=='중견기업'].count()
        smallmedium=dff[dff['기업규모']=='중소기업'].count()
        small=dff[dff['기업규모']=='소기업'].count()
        dfSize=pd.DataFrame({'대기업':big,'중견기업':medium,'중소기업':smallmedium,'소기업':small})
        # plt.bar(dfSize.columns,dfSize.values[1])
        # plt.show()
        plt.pie(dfSize.values[1],labels=dfSize.columns,autopct='%.1f%%')
        plt.title('{} 기업규모'.format(j))
        plt.savefig('data\{}_{}_기업규모.png'.format(o, j))
        plt.close()
        # plt.show()
        print('end!!!!!!!!!!!!!!!!!!!!!!!!1')
        print(x)
        if x%5==0:
            y=y+1
            break