document.addEventListener("DOMContentLoaded", function () {
    const formProduto = document.getElementById("formProduto");
    const tabelaProdutos = document.getElementById("tabelaProdutos");

    formProduto.addEventListener("submit", function (event) {
        event.preventDefault();


        const formData = new FormData(formProduto);


        fetch("/produtos/cadastro", {
            method: "POST",
            body: formData,
        })
                .then(response => {
                    if (!response.ok) {
                        throw new Error("Erro ao cadastrar produto");
                    }
                    return response.json();
                })
                .then(produto => {

                    const novaLinha = document.createElement("tr");
                    novaLinha.innerHTML = `
                <td>${produto.nome}</td>
                <td>${produto.tamanho || ""}</td>
                <td>${produto.descricao || ""}</td>
                <td>${produto.quantidade || ""}</td>
                <td>${produto.valor || ""}</td>
            `;
                    tabelaProdutos.appendChild(novaLinha);


                    formProduto.reset();
                })
                .catch(error => {
                    console.error("Erro:", error);
                    alert("Erro ao cadastrar produto");
                });
    });
});


