# Python Tool 정리

## 시작하면서

이 ReadMe 파일은 내가 알고리즘 문제를 풀면서 몰랐던 Library나 Tool을 공부하기 위하여 정리하는 파일



## 목차

* [Itertool](#Itertools)
* [Zip](#Zip)
* [Startswith](#startswith)
* [re(정규표현식)](#re)



## Itertools



### 적용 문제

많음 아주 많음















## Zip



### 적용문제

* PG_Level2_전화번호 목록









## Startswith

### 정의

특정 2개의 문자열(A, B)을 사용하여 A 문자열이 B로 시작하는지 확인하여 그렇다면 True, 그렇치 않으면 False 반환 

### 문법

```python
str.startswith(str, beg=0, end=len(string))
```

* 매개변후
  * str : 문자열
  * strbeg : 선택적 매개변수 / 문자열 검색 시작 위치 설정
  * strend : 선택적 매개변후 / 문자열 검색 끝 위치 설정

### 예시

```PY
A = "this is string example"
B = "this"
print(A.startswith(B))
print(A.startswith("is", 2, 4))
print(A.startswith("string", 2, 4))
```

```python
True
True
False
```

### 적용문제

* PG_Level2_전화번호 목록



## re

### 정의

* 특정한 규칙을 가진 문자열의 패턴을 표현하는 데 사용하는 표현식
* 문자열에서 특정 문자열을 검색하거나 치환할 때 흔히 사용

### 문법



### 적용문제

* PG_Level2_파일명 정렬











