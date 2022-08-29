<template>
    <table class="w-full text-sm text-left text-gray-500 dark:text-gray-400">
        <employee-node 
            v-for="employee in employees" 
            :key="employee.employeeId" 
            :employee="employee" 
        />
    </table>
</template>


<script>
import EmployeeNode from './EmployeeNode.vue'

export default {
    components: {
        EmployeeNode
    },

    props: {
        employees: {
            type: Array,
            required: true
        }
    }
}
</script>
