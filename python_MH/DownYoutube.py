import os
import pandas as pd
from pydub import AudioSegment

# 경로 설정
base_dir = 'C:/Users/Minhyeok/Desktop/git/LineNo5/python_MH/audio/'
os.chdir(base_dir)

# 리스트 불러와서 가공하기 쉽게 데이터 프레임으로 생성
data = pd.read_csv('List.txt', sep = "\t", encoding = "UTF-8")
sample_df = pd.DataFrame(data=data)

for number in range(len(sample_df)):
    mp3_file = base_dir + "{}.mp3".format(str(number)) # mp3 파일 선택
    wav_file = base_dir + "{}.wav".format(str(number)) # wav 파일 만들기
    cmd = "ffmpeg -i {} -vn {} -y".format(mp3_file, wav_file) # mp3를 wav로 변환
    os.system(cmd) # 실행
    # os.remove(mp3_file) # mp3 파일 제거
    song = AudioSegment.from_wav("{}.wav".format(str(number))) # wav 파일 선택
    one_seconds = 1000 # 1초
    five_seconds = 5 * 1000 # 5초
    ten_seconds = 10 * 1000 # 10초
    first_1_seconds = song[:one_seconds] # 앞부분 1초 자르기
    first_5_seconds = song[:five_seconds] # 앞부분 5초 자르기
    first_10_seconds = song[:ten_seconds] # 앞부분 10초 자르기
    first_1_seconds.export("OneSecond/{}.wav".format(str(number)), format="wav") # wav파일 다시저장
    first_5_seconds.export("FiveSecond/{}.wav".format(str(number)), format="wav") # wav파일 다시저장
    first_10_seconds.export("TenSecond/{}.wav".format(str(number)), format="wav") # wav파일 다시저장
    os.remove(wav_file)