const app = Vue.createApp({
    data() {
        return {
            books: [],        // 商品列表
            bookCount: 0,     // 商品數量
            errorText: '',       // 錯誤訊息
            sortOption: '',      // 排序選項
            isLoggedIn: false    // 登入狀態
        }
    },
    mounted() {
        this.fetchProducts();
        this.checkLogin();
    },
    methods: {
        fetchProducts() {
            fetch('/books/list')
                .then(res => res.json())
                .then(data => {
                    this.products = data;
                    this.productCount = data.length;
                })
                .catch(() => {
                    this.errorText = '載入書籍失敗';
                });
        },
        sortProducts() {
            if (this.sortOption === 'newest') {
                this.products.sort((a,b) => new Date(b.createdAt) - new Date(a.createdAt));
            }
        },
        borrow(inventoryId) {
            // 呼叫後端借書 API
            fetch('/books/borrow', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ inventoryId })
            })
            .then(res => res.json())
            .then(data => {
                alert('借書成功！');
            })
            .catch(err => {
                alert('借書失敗');
            });
        },
        checkLogin() {
            // 假設有 API 檢查登入
            fetch('/api/check-login')
                .then(res => res.json())
                .then(data => {
                    this.isLoggedIn = data.loggedIn;
                });
        }
    }
}).mount('#app');