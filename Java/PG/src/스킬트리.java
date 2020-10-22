public class 스킬트리 {
    public static void main(String[] args){
        int result = solution("CBD", new String[]{"BACDE","CBADF","AECB","BDA"});
        System.out.println(result);
    }
    public static int solution(String skill, String[] skill_trees){
        int answer = 0;
        int N = skill.length();
        for(String skill_tree : skill_trees){
            int count = -1;
            boolean flag = true;
            int n = skill_tree.length();
            for(int idx=0; idx < n; idx++){
                for(int idx2 = 0; idx2 < N; idx2++){
                    if (skill_tree.charAt(idx) == skill.charAt(idx2)){
                        if(count == -1){
                            if(idx2 == 0){
                                count = idx2;
                            }else{
                                flag = false;
                                break;
                            }
                        }else{
                            if (idx2 < count){
                                flag = false;
                            }else{
                                count = idx2;
                            }
                        }
                        break;
                    }
                    if (!flag){
                        break;
                    }
                }
                if (!flag){
                    break;
                }
            }
            if (flag){
                answer += 1;
            }
        }
        return answer;
    }
}
