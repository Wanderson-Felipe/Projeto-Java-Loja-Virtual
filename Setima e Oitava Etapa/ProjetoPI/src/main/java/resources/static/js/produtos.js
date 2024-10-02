$(document).ready(function () {
    let products = [];
    let selectedProductIndex = -1;

    $('#productForm').on('submit', function (event) {
        event.preventDefault();

        const nomeProduto = $('#nomeProduto').val();
        const tamanho = $('#tamanho').val();
        const descricao = $('#descricao').val();
        const quantidade = $('#quantidade').val();
        const valor = $('#valor').val();

        if (nomeProduto && tamanho && quantidade && valor) {
            const newProduct = {nomeProduto, tamanho, descricao, quantidade, valor};

            if (selectedProductIndex === -1) {
                products.push(newProduct);
            } else {
                products[selectedProductIndex] = newProduct;
                selectedProductIndex = -1;
            }

            updateProductTable();
            clearProductForm();
        } else {
            alert('Por favor, preencha os campos obrigatórios.');
        }
    });

    $('#clearForm').on('click', clearProductForm);

    function clearProductForm() {
        $('#productForm')[0].reset();
        selectedProductIndex = -1;
    }

    function updateProductTable() {
        const tableBody = $('#productTable tbody');
        tableBody.empty();

        products.forEach((product, index) => {
            const row = `<tr>
                <td>${product.nomeProduto}</td>
                <td>${product.tamanho}</td>
                <td>${product.descricao || ''}</td>
                <td>${product.quantidade}</td>
                <td>${product.valor}</td>
                <td>
                    <button onclick="editProduct(${index})">Alterar</button>
                    <button onclick="deleteProduct(${index})">Excluir</button>
                </td>
            </tr>`;
            tableBody.append(row);
        });
    }

    window.editProduct = function (index) {
        const product = products[index];
        $('#nomeProduto').val(product.nomeProduto);
        $('#tamanho').val(product.tamanho);
        $('#descricao').val(product.descricao);
        $('#quantidade').val(product.quantidade);
        $('#valor').val(product.valor);
        selectedProductIndex = index;
    };

    window.deleteProduct = function (index) {
        if (confirm('Tem certeza que deseja excluir este produto?')) {
            products.splice(index, 1);
            updateProductTable();
        }
    };
});


