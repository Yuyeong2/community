{
    const dataElem = document.querySelector('#data');

    const delBtnElem = document.querySelector('#delBtn');
    delBtnElem.addEventListener('click', () => {
        const iboard = dataElem.dataset.iboard;
        const icategory = dataElem.dataset.icategory;
        if (confirm(msg.fnIsDel(`${iboard}번 글`))) {
            location.href = `/board/del?icategory=${icategory}&iboard=${iboard}`;
        }
    });
}