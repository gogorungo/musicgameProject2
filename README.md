# LineNo5

### 현재 Main패키지에 main클래스와 연동되어 View 패키지만 작동함
 * 음악 실행중 게임 창 종료시 음악 계속 재생되고있음
# 2022_02_3까지 작업한 GUI
## 1. 메인화면
![01](https://user-images.githubusercontent.com/76654360/151514062-cec0e935-dec5-4767-bb2e-a54ebca71ad8.jpg)
  * 플레이버튼 클릭시 다음 화면으로 넘어감

## 2. 선택화면
![02](https://user-images.githubusercontent.com/76654360/151514145-558a90bb-3182-4ed4-b84e-18d69086f530.jpg)
  * 싱글 플레이 난이도 3개와 멀티 플레이 선택화면

## 3. 싱글 게임 화면(구현중)
![image](https://user-images.githubusercontent.com/76654360/152303822-9da3b317-9ef0-4c16-9904-4d91474b86a4.png)
![image](https://user-images.githubusercontent.com/76654360/152303862-5e74632e-2bcc-4cbb-8437-551f438eed5a.png)
  * 왼쪽 상단 재생 버튼 누르면 랜덤으로 음악재생 (2022_02_03 추가)
  * 힌트, 넥스트 버튼 작동(2022_02_03 추가)

    
# 2022_02_03 수정사항
 * 갑작스럽게 파이썬 pytube가 오류뜨면서 작동이 안됨 ('nonetype' object has no attribute 'span')
 * List.txt에 있는 링크를 따로 mp3형식으로 하나씩 저장 -> 파이썬으로 1초 5초 10초로 각각 폴더 나누어서 저장
 * 추후 음악 추가시, List.txt에 링크, 제목, 가수 적고 mp3파일을 따로 다운로드받은 후 파이썬 파일 실행하면 각각 폴더에 저장됨.
 * 싱글 게임 화면을 따로 프레임 생성

# 2022_02_04 수정사항
 * 힌트, 넥스트 버튼 누르고 다른 싱글게임 누르면 카운트 초기화
 * View패키지 정리
 * 멀티 게임 화면 구현
![image](https://user-images.githubusercontent.com/76654360/152489100-b98f89db-e4d1-40a6-92dd-1cb9252ccf93.png)


# 2022_02_07 수정사항
 * 싱글 - 힌트 버튼누르면 힌트 보임, 정답 카운트 추가, 타이머 추가
 * 싱글 - 다음버튼누르거나 정답을 맞추면 가운데 사진이 정답 사진으로 교체
 * 멀티 - 화면 UI 위치 수정
![image](https://user-images.githubusercontent.com/76654360/152748830-6c831a11-5955-4227-9986-3d1227f80b59.png)
![image](https://user-images.githubusercontent.com/76654360/152748892-fb37e5a8-f20a-490c-8226-8c3a7f81ef24.png)
![image](https://user-images.githubusercontent.com/76654360/152748973-1706abed-4d1c-4548-b4b4-539fa6a6ce34.png)


