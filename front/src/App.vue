<template>
  <nav-bar />
  <department-tree />
</template>


<script>
import DepartmentTree from './components/DepartmentTree.vue'
import NavBar from './components/NavBar.vue'

export default {
  name: "App",

  components: {
    DepartmentTree, 
    NavBar
  },

  data() {
    return {

    }
  }, 

}
</script>

