$(document).ready(function () {

    $("#cpf").inputmask("999.999.999-99");
    $("#telefone").inputmask("(99)99999-9999");


    $("form").on("submit", function (event) {
        const telefone = $("#telefone").val();
        const regexTelefone = /^\(\d{2}\)\d{5}-\d{4}$/;

        if (!regexTelefone.test(telefone)) {
            alert("O telefone deve estar no formato (##)#####-####");
            event.preventDefault();
        }
    });


    $("a[onclick^='confirmarExclusao']").on("click", function (event) {
        return confirmarExclusao(event);
    });
});


function confirmarExclusao(event) {
    if (!confirm('Tem certeza que deseja excluir este cliente?')) {
        event.preventDefault();
        return false;
    }
    return true;
}