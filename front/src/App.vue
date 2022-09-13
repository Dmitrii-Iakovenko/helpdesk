<template>
  <header class="sticky top-0">
    <nav-bar />
  </header>
  <main>
    <ticket-list />
  </main>
  <footer></footer>
</template>


<script>
import DepartmentTree from './components/DepartmentTree.vue'
import NavBar from './components/NavBar.vue'
import TicketList from './components/TicketList.vue'


export default {
  name: "App",

  components: {
    DepartmentTree, 
    NavBar,
    TicketList
  },

  data() {
    return {

    }
  }, 

}
</script>

