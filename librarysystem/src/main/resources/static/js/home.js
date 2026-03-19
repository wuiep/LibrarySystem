const app = Vue.createApp({
    data() {
        return {
            books: [],
            bookCount: 0,
            errorText: '',
            sortOption: '',
        }
    },
    mounted() {
        this.fetchBooks();
    },
    methods: {
        fetchBooks() {
            fetch('/books/list')
                .then(res => res.json())
                .then(data => {
                    this.books = data;
                    this.bookCount = data.length;
                })
                .catch(() => {
                    this.errorText = '載入書籍失敗';
                });
        },
        sortBooks() {
            if (this.sortOption === 'newest') {
                this.books.sort((a,b) => new Date(b.storeTime) - new Date(a.storeTime));
            }
        },
        borrow(inventoryId) {
            fetch('/books/borrow', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ inventoryId })
            })
            .then(res => {
                if (res.status === 401) {
                    window.location.href = '/login.html';
                    return;
                }
                return res.json();
            })
            .then(data => {
                if (data) {
                    alert('借書成功');
                    this.fetchBooks();
                }
            })
            .catch(() => {
                alert('借書失敗');
            });
        },
        returnBook(inventoryId) {
            fetch('/books/return', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ inventoryId })
            })
            .then(res => {
                if (res.status === 401) {
                    window.location.href = '/login.html';
                    return;
                }
                return res.json();
            })
            .then(data => {
                if (data) {
                    alert('還書成功');
                    this.fetchBooks();
                }
            })
            .catch(() => {
                alert('還書失敗');
            });
        }
    }
}).mount('#app');