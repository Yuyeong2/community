{
    const dataElem = document.querySelector('#data');

    //삭제 버튼
    const delBtnElem = document.querySelector('#delBtn');
    if(delBtnElem) {
        delBtnElem.addEventListener('click', ()=> {
            const icategory = dataElem.dataset.icategory;
            const iboard = dataElem.dataset.iboard;

            if(confirm(msg.fnIsDel(`${iboard}번 글`))) {
                location.href=`/board/del?icategory=${icategory}&iboard=${iboard}`;
            }
        });
    }

    //수정 버튼
    const modBtnElem = document.querySelector('#modBtn');
    if(modBtnElem) {
        modBtnElem.addEventListener('click', ()=> {
            const iboard = dataElem.dataset.iboard;
            location.href=`/board/mod?iboard=${iboard}`;
        });
    }
}