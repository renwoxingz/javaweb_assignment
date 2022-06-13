/**
 * 获取组件
 * @type {HTMLElement}
 */
const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');
const btn_Merchant = document.getElementById('btn_Merchant');
const btn_Login = document.getElementById('btn_Login');

/**
 * 点击切换
 */
signUpButton.addEventListener('click', () => {
    container.classList.add("right-panel-active");
});

signInButton.addEventListener('click', () => {
    container.classList.remove("right-panel-active");
});

/**
 * 商家登录
 */
btn_Merchant.addEventListener('click',()=>{
    const name = document.getElementById('name_Merchant').value;
    const password = document.getElementById('password_Merchant').value;
    if(isEmpty(name)){
        alert("姓名不能为空");
        return;
    }
    if(isEmpty(password)){
        alert("密码不能为空");
        return;
    }

    document.getElementById('merchantLogin').submit();
});

/**
 * 登录
 */
btn_Login.addEventListener('click',()=>{
    const name = document.getElementById('name_Login').value;
    const password = document.getElementById('password_Login').value;

    if(isEmpty(name)){
        alert("姓名不能为空");
        return;
    }
    if(isEmpty(password)){
        alert("密码不能为空");
        return;
    }
    document.getElementById('loginInfo').submit();
});


function isEmpty(str){
    if(str===null||str.trim()==""){
        return true;
    }
    return false;
}


