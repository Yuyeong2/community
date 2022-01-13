{
    const upwChangeElem = document.querySelector('#upwChange');

    if(upwChangeElem) {
        upwChangeElem.addEventListener('submit', (e) => {
            const currentupwVal = upwChangeElem.currentupw.value;
            const upwVal = upwChangeElem.upw.value;
            const confirmupwVal = upwChangeElem.confirmupw.value;
            if(currentupwVal.length === 0) {
                alert('현재 비밀번호를 입력해 주세요.');
                e.preventDefault();
            } else if(upwVal.length === 0) {
                alert('변경 비밀번호를 입력해 주세요.');
                e.preventDefault();
            } else if(upwVal !== confirmupwVal) {
                alert('변경 비밀번호와 확인 비밀번호가 다릅니다.');
                e.preventDefault();
            } else if(regex.isWrongWith('pw', currentupwVal)) {
                alert(`현재 비밀번호가 ${regex.msg.pw}인지 확인해 주세요.`);
                e.preventDefault();
            } else if(regex.isWrongWith('pw', upwVal)) {
                alert(`변경 비밀번호가 ${regex.msg.pw}인지 확인해 주세요.`);
                e.preventDefault();
            }
        });
    }
}