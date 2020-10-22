public class 스킬트리 {
    public static void main(String[] args){
        int result = solution("CBD", new String[]{"BACDE","CBADF","AECB","BDA"});
        System.out.println(result);
    }
    public static int solution(String skill, String[] skill_trees){
        int answer = 0;
        int N = skill.length();
        for(String skill_tree : skill_trees){
            int count = 0;
            boolean flag = true;
            int n = skill_tree.length();
            for(int idx=0; idx < n; idx++){
                for(int idx2 = count; idx2 < N; idx2++){
                    if(skill.charAt(idx2) == skill_tree.charAt(idx)){
                        if(idx2 != count){
                            flag = false;
                            break;
                        }else{
                            count += 1;
                            break;
                        }
                    }
                }
            }
            if (flag){
                answer += 1;
            }
        }
        return answer;
    }
}
