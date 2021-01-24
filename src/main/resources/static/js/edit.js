tableContent.addEventListener('click', (e) => {

    //если зеленая кнопка нажата (для идентификации в динамические кнопки ввел поле name)
    if (e.target.name == 'Green2') {
        console.log(e.target.id)

        //вытаскиваем айдишник кнопки (в него зашит айдишник юзера, он один и тот же)
        const idNumEdit = e.target.id
        //можем заполнить первую графу модального окна, т.к. айдишник знаем
        $('#idEdit').val(idNumEdit)

        //по айдишнику получаем юзера и заполняем оставшиеся графы в модальном окне
        const urlOne = 'http://localhost:8080/api/one'
        fetch(`${urlOne}/${idNumEdit}`)
            .then(response => response.json())
            .then(user => {
                $('#firstnameEdit').attr('value', `${user.firstname}`)
                $('#lastnameEdit').attr('value', `${user.lastname}`)
                $('#ageEdit').attr('value', `${user.age}`)
                $('#emailEdit').attr('value', `${user.email}`)
                $('#passwordEdit').attr('value', `${user.password}`)
                const admCh = document.getElementById('isadmin')
                const userCh = document.getElementById('isuser')
                //очищаем checkbox
                admCh.checked = false
                userCh.checked = false
                //заполняем checkbox данными о ролях
                for (let item of user.roles) {
                    if (item.role == 'ADMIN') {
                        admCh.checked = true
                    }
                    if (item.role == 'USER') {
                        userCh.checked = true
                    }
                }
            })
    }
})

function sendEdit() {

    var admCheck = Boolean(false)
    var userCheck = Boolean(false)

    if ($('#isadmin').prop("checked")) {
        admCheck = true
    }
    if ($('#isuser').prop("checked")) {
        userCheck = true
    }
    const idEdit = $('#idEdit').val()

    const userEdit = {
        id: $('#idEdit').val(),
        firstname: $('#firstnameEdit').val(),
        lastname: $('#lastnameEdit').val(),
        age: $('#ageEdit').val(),
        email: $('#emailEdit').val(),
        password: $('#passwordEdit').val(),
        isuser: userCheck,
        isadmin: admCheck
    }

    const urlEdit = 'http://localhost:8080/api/edit'

    fetch(`${urlEdit}/${idEdit}`, {
        method: 'PATCH',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(userEdit)
    })
        .then(response => response.json())
        .then(() => location.reload())
}