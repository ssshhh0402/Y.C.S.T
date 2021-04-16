package EstSoft;


public class Pro1_2 {
        public static int solution(String p, String s) {
            int answer = 0;                // 바뀐 횟수 저장하기 위한 변수
            int count = 0;                 // p에서 비교할 단어의 위치를 지정하기 위한 변수단(0 ~ p의 길이)
            int m = p.length();
            int n = s.length();
            int added = 0;                 // 동일한 문자열의 갯수
            boolean flag = false;          // s안에 p와 동일한 문자열이 한개라도 존재하는지 구분하기위한 변수
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == p.charAt(count)) {        //s의 단어와 p의 단어가 동일한지 판단
                    count += 1;                              //그 다음 단어를 비교하기위해 count += 1
                    added += 1;
                } else {
                    answer += 1;                            //동일하지 않다면 해당 단어는 삭제
                }
                if (count == m) {                          // p 단어 끝까지 비교했다면
                    flag = true;                           // flag 변경하고 다시 처음부터(count = 0) 비교
                    count = 0;
                }
            }
            if (flag) {                                    // 동일한 단어열이 한개라도 존재한다면
                return answer + (added % m);               // added % m = 값은 동일하나 남는 단어의 개수
            } else {
                return -1;                                 // 존재하지 않다면 -1 반환
            }
        }

    public static void main(String[] args){
        System.out.println(solution("101","10100010101101100"));
        System.out.println(solution("110","110110110"));
        System.out.println(solution("000", "00000000"));
        System.out.println(solution("00","1111111"));
    }
}
