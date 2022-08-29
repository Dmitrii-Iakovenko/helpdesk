<template>
    <div class="space-y-2.5 p-2.5">
        <div class="p-2.5 border rounded border-grid"
            v-for="organization in organizations" :key="organization.department_id">
            <department-node :department="organization" />
        </div>
    </div>
</template>

<script>
import DepartmentNode from './DepartmentNode.vue'

export default {
    components: {
        DepartmentNode
    },

    data() {
        return {
            departments: [],
            employees: []
        }
    },

    mounted() {
        const BACKEND_API_HOST_PORT = import.meta.env.VITE_BACKEND_API_HOST_PORT;
        fetch(BACKEND_API_HOST_PORT + 'api/v1/employees')
            .then((response) => response.json())
            .then((data) => this.employees = data);        
        fetch(BACKEND_API_HOST_PORT + 'api/v1/departments')
            .then((response) => response.json())
            .then((data) => this.departments = data);
    },
    
    computed: {
        organizations() {
            // select Organization
            let organizations = this.departments
                .filter(department => department.parent_id === 0);
            // select all Departments (childs)
            organizations.forEach(organization => organization.child = this.getAllChild(organization));
            this.departments.forEach(department => department.employees = this.getAllEmployees(department));
            return organizations;
        }
    },

    methods: {
        getAllChild(organization) {
            let child = this.departments
                .filter(department => department.parent_id === organization.department_id);
            child.forEach(subChild => subChild.child = this.getAllChild(subChild));
            return child;
        },

        getAllEmployees(department) {
            return this.employees
                .filter(employee => employee.departmentId === department.department_id);
        }
    }


}
</script>
