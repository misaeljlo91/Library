const app = Vue.createApp({
    data(){
        return{
            listBooks: [],
            data:{
                title: "",
                writer: "",
                price: "",
                releaseDate: ""
            },
            filterBook: [],
            searchBook: "",
            noBook: false,
            orderTitleAZ: true, orderTitleZA: false,
            orderWriterAZ: true, orderWriterZA: false
        }
    },
    created(){
        this.dataBooks()
    },
    methods:{
        dataBooks(){
            axios.get("/api/book?page=2")
            .then(response => {
                this.listBooks = response.data.content

                this.orderById(this.listBooks)
            })
        },
        orderById(array){
            return array.sort((a, b) => {
                if(a.id < b.id){
                    return -1
                }else if(a.id > b.id){
                    return 1
                }else{
                    return 0
                }
            })
        },
        orderByTitle(array, order){
            if(order == "A-Z"){
                this.orderTitleAZ = false
                this.orderTitleZA = true

                return array.sort((a, b) => {
                    if(a.title < b.title){
                        return -1
                    }else if(a.title > b.title){
                        return 1
                    }
                })
            }

            if(order == "Z-A"){
                this.orderTitleAZ = true
                this.orderTitleZA = false

                return array.sort((a, b) => {
                    if(a.title > b.title){
                        return -1
                    }else if(a.title < b.title){
                        return 1
                    }
                })
            }
        },
        orderByWriter(array, order){
            if(order == "A-Z"){
                this.orderWriterAZ = false
                this.orderWriterZA = true

                return array.sort((a, b) => {
                    if(a.writer < b.writer){
                        return -1
                    }else if(a.writer > b.writer){
                        return 1
                    }
                })
            }

            if(order == "Z-A"){
                this.orderWriterAZ = true
                this.orderWriterZA = false

                return array.sort((a, b) => {
                    if(a.writer > b.writer){
                        return -1
                    }else if(a.writer < b.writer){
                        return 1
                    }
                })
            }
        },
        momentDateRelease(date){
            return moment(date).format("DD/MM/YYYY")
        },
        momentDateFooter(date){
            return moment(date).format("YYYY")
        },
        numberFormat(data){
            return numeral(data).format("0,0.00")
        },
        postBook(){
            swal({
                title: "Confirmación",
                text: "¿Está seguro de querer registrar este libro?",
                icon: "warning",
                buttons: true
            })
            .then(confirmation => {
                axios.post("/api/book",{
                    title: this.data.title,
                    writer: this.data.writer,
                    price: this.data.price,
                    date: this.data.releaseDate
                })
                .then(response => {
                    swal({
                        title: "Registro exitoso",
                        icon: "success",
                        button: true
                    })
                    .then(response => {
                        window.location.reload()
                    })
                })
                .catch(error =>{
                    swal({
                        title: "¡Atención!",
                        text: error.response.data,
                        icon: "error"
                    })
                })
            })
        },
        deleteBook(id){
            this.bookID = id;

            swal({
                title: "Confirmación",
                text: "¿Está seguro de querer eliminar este libro?",
                icon: "warning",
                buttons: true
            })
            .then(confirmation => {
                if(confirmation){
                    axios.delete(`/api/book/${this.bookID}`,{headers:{'content-type':'application/x-www-form-urlencoded'}})
                    .then(response => {
                        swal({
                            title: "Libro eliminado",
                            icon: "success",
                            button: true
                        })
                        .then(response =>{
                            window.location.reload()
                        })
                    })
                }
            })
        },
        signOut(){
            swal({
                text: "¿Estás seguro que quiere cerrar sesión?",
                icon:"warning",
                buttons: true
            })
            .then(confirmation => {
                if(confirmation){
                    axios.post("/api/logout")
                    .then(response=>{
                        window.location.replace("index.html")
                    })
                }
            })
        }
    },
    computed:{
        searchBooks(){
            this.filterBook = this.listBooks.filter(book => book.title.toLowerCase().includes(this.searchBook.toLowerCase()));

            this.noSearch;
            return this.filterBook
        },
        noSearch(){
            if(this.filterBook.length === 0){
                return this.noBook = true
            }else{
                return this.noBook = false
            }
        }
    }
})
app.mount("#app")