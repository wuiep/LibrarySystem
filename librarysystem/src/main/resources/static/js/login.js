const app = Vue.createApp({
    data() {
        return {
            loginForm: { phoneNumber: '', password: '' },
            registerForm: { phoneNumber: '', password: '', email: '',username:'' },
            showRegisterModal: false,
            loginError: '',
            registerError: '',
            registerSuccess: ''
        }
    },
    methods: {
        login() {
            fetch('/loginController/login', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(this.loginForm)
            })
            .then(res => res.json())
            .then(data => {
                if(data.success){
                    this.loginError = '';
                    alert('登入成功');
                    window.location.href = '/home.html';
                } else {
                    this.loginError = data.message;
                }
            })
            .catch(() => { this.loginError = '登入發生錯誤'; });
        },
        register() {
            fetch('/userController/addUser', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(this.registerForm)
            })
            .then(res => res.json())
            .then(() => {
                this.registerError = '';
                this.registerSuccess = '註冊成功，請登入';
                this.showRegisterModal = false;
                this.registerForm = { phoneNumber:'', password:'', email:'',username:''};
            })
            .catch(() => { this.registerError = '註冊發生錯誤'; });
        }
    }
}).mount('#app');