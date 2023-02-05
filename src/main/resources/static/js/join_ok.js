function sendit(){

    const name = document.getElementById('prName');
    const hp = document.getElementById('prHp');
    const userpw = document.getElementById('prUserpw');
    const userpw_re = document.getElementById('passwordConfirm');
    const nick = document.getElementById('prNick');


    // 정규 표현식
    const expNameText = /[가-힣]+$/;                    // 한글만 가능
    const expHpText = /^\d{3}\d{3,4}\d{4}$/;            // (-) 제외
    const expPwText = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,}/;
    const expNickText = /^[A-Za-z]{4,20}$/;             // $는 여기서 종료했다는 뜻


    if(!expNameText.test(name.value)){
        alert('성명은 두 글자 이상으로 입력하세요');
        name.focus();
        return false;
    }

    if(!expHpText.test(hp.value)){
        alert('휴대폰번호 형식을 확인하세요\n하이픈(-)을 제외해야 합니다');
        hp.focus();
        return false;
    }
    
    if(!expPwText.test(userpw.value)){
        alert('비밀번호 형식을 확인하세요\n소문자,대문자,숫자,특수문자를 1개씩 꼭 입력해야합니다.');
        userpw.focus();
        return false;
    }

    if(userpw.value != userpw_re.value){
        alert('비밀번호와 비밀번호 확인의 값이 다릅니다');
        userpw_re.focus();
        return false;
    }

    if(!expNickText.test(nick.value)){
        alert('닉네임은 4자 이상 20자 이하의 대소문자로 시작하는 조합입니다');
        nick.focus();
        return false;
    }

    return true;        // return은 하나만 있어야돼
    
}