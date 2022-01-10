{
    const joinFrmElem = document.querySelector('#join-frm');
    const idChkMsgElem = joinFrmElem.querySelector('#id-chk-msg');
    let idChkState = 2;
    const idRegex = /^([a-zA-Z0-9]{4,15})$/;
    const pwRegex = /^([a-zA-Z0-9!@_]{4,20})$/;
    const nmRegex = /^([가-힣]{2,10})$/;
    const msg1 = '아이디는 대소문자, 숫자 조합으로 4~15 글자가 되어야 합니다.';

    const setIdChkMsg = (data) => {
        idChkState = data.result;
        switch (data.result) {
            case 0:
                idChkMsgElem.innerText = '이미 사용 중인 아이디 입니다.';
                break;
            case 1:
                idChkMsgElem.innerText = '사용할 수 있는 아이디 입니다.';
                break;
        }
    };

    if(joinFrmElem) {
        joinFrmElem.addEventListener('submit', (e) => {
            const uid = joinFrmElem.uid.value;
            const upw = joinFrmElem.upw.value;
            const upwChk = joinFrmElem.upwChk.value;
            const nm = joinFrmElem.nm.value;

            if(!idRegex.test(uid)) {
                alert(msg1);
                e.preventDefault();
                return;
            } else if(!pwRegex.test(upw)) {
                alert('비밀번호는 대소문자, 숫자, !, @, _ 조합으로 4~20 글자가 되어야 합니다.');
                e.preventDefault();
            } else if(upw !== upwChk) {
                alert('비밀번호가 맞지 않습니다.');
                e.preventDefault();
            } else if(!nmRegex.test(nm)) {
                alert('이름은 한글로 2~10 글자가 되어야 합니다.');
                e.preventDefault();
            }

            if(idChkState !== 1) {
                switch (idChkState) {
                    case 0:
                        alert('다른 아이디를 사용해 주세요');
                        break;
                    case 2:
                        alert('아이디 중복체크를 해주세요.');
                        break;
                }
              e.preventDefault();
            }
        });

        joinFrmElem.uid.addEventListener('keyup', () => {
            idChkState = 2;
            idChkMsgElem.innerText= '';
        });

        const idBtnChkElem = joinFrmElem.querySelector('#id-btn-chk');
        idBtnChkElem.addEventListener('click', () => {
            const idVal = joinFrmElem.uid.value;
            if(idVal.length < 4) {
                alert('아이디를 4자 이상 작성해주세요.');
                return;
            }
            if(!idRegex.test(idVal)) {
                alert(msg1);
                return;
            }

            fetch(`/user/idChk/${idVal}`)
                .then(res => res.json())
                .then((data) => {
                    console.log(data);
                    idChkState = data.result;
                    setIdChkMsg(data);
                }).catch((e) => {
                    console.log(e);
            });
        });
    }
}
