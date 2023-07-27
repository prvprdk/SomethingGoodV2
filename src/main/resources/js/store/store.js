import Vue from 'vue'
import Vuex from 'vuex'
import messageApi from 'api/message'

Vue.use(Vuex)

export default new Vuex.Store({
  state:{
        profile: frontendData.profile,
        messages: frontendData.messages,
  },
  mutations: {
    addMessageMutation (state, message){
            this.state.messages.push (message)
        }
  },
  actions: {
    async addMessageAction ({commit}, message){
        const result = await messageApi.add(message)

    }
  }
})
