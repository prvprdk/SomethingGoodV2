<template>
<v-app>
     <v-app-bar app>
        <v-toolbar-title @click="$router.push('/')">SomethingGood</v-toolbar-title>
        <v-spacer></v-spacer>
         <div v-if="profile">{{profile.username}}
            <a href="/logout">
                <v-btn icon>
                 <v-icon>logout</v-icon>
                </v-btn>
            </a></div>
     </v-app-bar>

<v-main  style="background: #77DDE7;">
             <router-view ></router-view>
</v-main>

<v-footer
    dark
    padless
  >
      <v-card-text class="py-2 white--text text-center">
        {{ new Date().getFullYear() }} — <strong>how do you do, fellow kids</strong>
      </v-card-text>
    </v-card>
  </v-footer>

</v-app>
</template>
<script>
import { mapState, mapMutations } from 'vuex'
import { addHandler } from 'util/ws'

export default {
          computed: mapState(['profile', 'messages']),
          methods: {
            ...mapMutations (['addMessageMutation'])
          },
          created () {
            addHandler(data => {
                if (data.objectType === 'MESSAGE' && data.body.author.id != this.profile.id) {
                    this.addMessageMutation(data.body)
                }
            })
          },
          beforeMount ()     {
                if (this.profile == null){
                this.messages = ''
                this.$router.replace('/auth')
                }
            }
    }
</script>

<style scoped>
</style>