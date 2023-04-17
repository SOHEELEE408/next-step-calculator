public class RegexPractice {

    /**
     * 휴대 전화 번호
     *
     * ^ : 시작
     * | : 또는
     * [0-9] : 숫자 0~9 중 1개
     * \d{min, max} : 길이 최소, 최대
     * $ : 끝
     */
    String phoneNumberRegex = "^01(?:0|1|[6-9])-[0-9]\\d{3,4}-[0-9]\\d{4}$";


    /**
     * 이메일
     */
    String emailRegex = "^[a-zA-Z0-9]\\d{3,20}@[a-z].[a-z]$";

    /**
     * 비밀번호 - 알파벳 대소문자와 특수문자를 포함, 최대 길이 20
     *
     * (?=.*pattern) : Positive Lookahead(긍정형 전방 탐색) - 문자열 전체 중에서 pattern에 해당되는 문자열이 하나 이상 포함되어야 한다.
     */
    String passwordRegex = "(?=.*[a-z])(?=.*[A-Z])[a-zA-Z]+[`~!@#\\$%\\^&\\*\\(\\)-_\\+=\\|<>/\\?]+\\d{8,20}$";


}
