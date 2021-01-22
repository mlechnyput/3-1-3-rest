tableContent.addEventListener('click', (e)=>{

    //если красная кнопка нажата
    if (e.target.name=='Red1'){
        console.log(e.target.id)

        const idNumDel = e.target.id
        $('#id_Del').val(idNumDel)



    }
})

function sendDel(){
    const idNumDel=$('#id_Del').val()
    const urlDel = 'http://localhost:8080/api/del'
    fetch(`${urlDel}/${idNumDel}`,{
        method:'DELETE'
    })
        .then(res=>res.json())
        .then(()=>location.reload())
}