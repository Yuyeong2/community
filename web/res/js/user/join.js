{
    let idChkState = 2; //0: 아이디 사용 불가능, 1:아이디 사용가능, 2: 체크 안함
    const joinFrmElem = document.querySelector('#join-frm');
    const idRegex = /^([a-zA-Z0-9]{4,15})$/; //대소문자+숫자 조합으로 4~15글자인 경우만 OK!
    const pwRegex = /^([a-zA-Z0-9!@_]{4,20})$/; //대소문자+숫자+!@_ 조합으로 4~20글자인 경우만 OK!
    const nmRegex = /^([가-힣]{2,5})$/;
    const msg1 = '아이디는 대소문자, 숫자조합으로 4~15글자가 되어야 합니다.';

    const setIdChkMsg = (data) => {
        idChkState = data.result; //0 or 1

        const idChkMsgElem = joinFrmElem.querySelector('#id-chk-msg');
        switch(data.result) {
            case 0:
                idChkMsgElem.innerText = '이미 사용중인 아이디 입니다.';
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
            const upwChk = joinFrmElem.querySelector('#upw-chk').value;
            //const upwChk = joinFrmElem.upw-chk.value; //.점으로 자식 엘리먼트에 접근시 - 는 안된다. but _ 는 된다.
            const nm = joinFrmElem.nm.value;

            if(!idRegex.test(uid)) {
                alert(msg1);
                e.preventDefault();
            } else if (!pwRegex.test(upw)) {
                alert('비밀번호는 대소문자, 숫자, !@_ 조합으로 4~20글자가 되어야 합니다.');
                e.preventDefault();
            } else if(upw !== upwChk) {
                alert('비밀번호와 체크 비밀번호를 확인해 주세요.');
                e.preventDefault();
            } else if(!nmRegex.test(nm)) {
                alert('이름은 한글로 2~5글자가 되어야 합니다.');
                e.preventDefault();
            } else if(idChkState !== 1) {
                switch (idChkState) {
                    case 0:
                        alert('다른 아이디를 사용해 주세요!');
                        break;
                    case 2:
                        alert('아이디 중복 체크를 해주세요!');
                        break;
                }
                e.preventDefault();
            }
        });

        joinFrmElem.uid.addEventListener('keyup', () => {
            const idChkMsgElem = joinFrmElem.querySelector('#id-chk-msg');
            idChkMsgElem.innerText = '';
            idChkState = 2;
        });

        //아이디 중복 체크 버튼
        const idBtnChkElem = joinFrmElem.querySelector('#id-btn-chk');
        idBtnChkElem.addEventListener('click', () => {
            const idVal = joinFrmElem.uid.value;
            if(idVal.length < 4) {
                alert('아이디는 4자 이상 작성해 주세요.');
                return;
            } else if(!idRegex.test(idVal)) {
                alert(msg1);
                return;
            }
            /*
            fetch(`/user/idChk/${idVal}`)
            .then(res => res.json())
            .then((data) => {
                setIdChkMsg(data);
            }).catch((e)=> {
               console.log(e);
            });
             */
            myFetch.get(`/user/idChk/${idVal}`, (data) => {
                setIdChkMsg(data);
            });
        });
    }
}