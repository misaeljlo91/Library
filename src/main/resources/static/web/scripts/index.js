const app = Vue.createApp({
    data(){
        return{
            data:{
                username: "",
                password: ""
            },
            type: "password", hidden: true, show: false,
            error: false
        }
    },
    methods:{
        signIn(){
            axios.post("/api/login",`username=${this.data.username}&password=${this.data.password}`,{headers:{'content-type':'application/x-www-form-urlencoded'}})
            .then(response => {
                window.location.replace("manager.html")
            })
            .catch(error => {
                this.error = true
                this.data.username = ""
                this.data.password = ""
            })
        },
        momentDateFooter(date){
            return moment(date).format("YYYY")
        },
        showPassword(){
            if(this.type === "password"){
                this.type = "text"
                this.hidden = false
                this.show = true
            }else{
                this.type = "password"
                this.hidden = true
                this.show = false
            }
        }
    }
})
app.mount("#app")