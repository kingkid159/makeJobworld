import cx_Oracle
import os
occupation=['웹프로그래머','퍼블리싱UI개발','빅데이터AI']
job=[['웹개발', '자바', '백엔드', '프론트', 'jsp'], ['css', '퍼블리셔', '웹표준', '자바스크립', 'xml'], ['데이터분석',
      '인공지능','빅데이터','파이썬','머신러닝']]
graph=['평균연봉','경력별','학력별','기업규모']
x=0
y=0
for o in occupation:
    print(y)
    jobb=job[y]
    for j in jobb:
        x = x + 1
        print(x)
        for g in graph:
            connect = cx_Oracle.connect("job/job@localhost:1521/xe")
            cursor = connect.cursor()
            print(o,j,g)
            sql="insert into jobgraph (J_no,job,job_detail,Graph_type) values(j_no.nextval,'{}','{}','{}')".format(o,j,g)
            cursor.execute(sql)
            cursor.close()
            print(1)
            connect.commit()
            connect.close()
        if x%5==0:
            y=y+1
            break
