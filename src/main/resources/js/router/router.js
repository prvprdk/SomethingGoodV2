import Vue from 'vue'
import VueRouter from 'vue-router'
import MessageRow from 'components/MessageRow.vue'
import MessageForm from 'components/MessageForm.vue'
import Auth from 'pages/Auth.vue'

Vue.use(VueRouter)

const routes = [
                    {path: '/', component: MessageRow},
                    {path: '/set', component: MessageForm},
                    {path: '/auth', component: Auth},

]

export default new VueRouter({
  mode: 'history',
  routes

})