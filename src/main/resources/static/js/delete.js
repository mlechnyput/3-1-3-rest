tableContent.addEventListener('click', (e) => {

    //если красная кнопка нажата (для идентификации в динамические кнопки ввел поле name)
    if (e.target.name == 'Red1') {
        console.log(e.target.id)

        //вытаскиваем айдишник кнопки (в него зашит айдишник юзера, он один и тот же)
        const idNumDel = e.target.id
        //можем заполнить первую графу модального окна, т.к. айдишник знаем
        $('#id_Del').val(idNumDel)

        //по айдишнику получаем юзера и заполняем оставшиеся графы в модальном окне
        const urlOne = 'http://localhost:8080/api/one'
        fetch(`${urlOne}/${idNumDel}`)
            .then(response=>response.json())
            .then(user=>{
                $('#firstname_Del').attr('value', `${user.firstname}`)
                $('#lastname_Del').attr('value',`${user.lastname}`)
                $('#age_Del').attr('value',`${user.age}`)
                $('#email_Del').attr('value',`${user.email}`)
                $('#password_Del').attr('value',`${user.password}`)

                // пишем роли в строку
                let strRole = ''
                for (let item of user.roles) {
                    strRole += item.role + ' '
                }

                $('#roles_Del').attr('value',`${strRole}`)
            })
    }
})

//Удаление запускается кнопкой модального окна
function sendDel() {
    const idNumDel = $('#id_Del').val()
    const urlDel = 'http://localhost:8080/api/del'
    fetch(`${urlDel}/${idNumDel}`, {
        method: 'DELETE'
    })
        .then(res => res.json())
        .then(() => location.reload())
}