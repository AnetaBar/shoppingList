const endpoint = 'http://localhost:8080/listItems';

const productList = document.getElementById('productList');
const productNameTF = document.getElementById('productName');
const productQuantityTF = document.getElementById('productQuantity');
const saveBtn = document.getElementById('saveBtn');
const clearBtn = document.getElementById('clearBtn');

const clearProductListHtml = function () {
    while (productList.hasChildNodes()) {
        productList.removeChild(productList.lastChild);
    }
}

const getAllItems = function () {
    productNameTF.classList.remove('invalidTF');
    clearProductListHtml();
    const items = [];
    fetch(endpoint)
        .then(blob => blob.json())
        .then(data => {
            items.push(...data);
            const markup = items.map(item => {
                return `
	            <li class="singleRow">
		        <span class="productNameCell">${item.productName}</span>
		        <span class="productQuantityCell">${item.productQuantity}</span>
	            </li>
	            `;
            }).join('');
            productList.innerHTML = markup;
        });
}

const saveItem = function () {
    if (validate()) {
        fetch(endpoint, {
            method: 'POST',
            body: JSON.stringify({ 'productName': productNameTF.value, 'productQuantity': productQuantityTF.value}),
            headers: { 'Content-Type': 'application/json' }
        })//.then(blob => blob.json())
            .catch(error => console.error('Error: ', error))
            .then(() => {
                getAllItems();
                productNameTF.value = '';
                productQuantityTF.value = '1';
            });
    } else {
        productNameTF.classList.add('invalidTF');
    }
}

const validate = function () {
    if (productNameTF.value == "") {
        return false;
    }
    return true;
}

const removeAllItems = function () {
    fetch(endpoint, {
        method: 'DELETE'
    })
        .then(() => clearProductListHtml());
}

saveBtn.addEventListener('click', saveItem, false);
clearBtn.addEventListener('click', removeAllItems, false);
productNameTF.addEventListener('focus', function () { this.classList.remove('invalidTF') }, false);

document.addEventListener('DOMContentLoaded', getAllItems, false);

