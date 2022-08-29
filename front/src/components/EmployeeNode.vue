<template>
    <tr  class="bg-white border dark:bg-gray-800 dark:border-gray-700">
        <td class="py-4 px-6">{{ employee.jobPosition }}</td>
        <td class="py-4 px-6">{{ employee.lastName }}</td>
        <td class="py-4 px-6">{{ employee.cityPhone }}</td>
        <td class="py-4 px-6">{{ employee.localPhone }}</td>
        <td class="py-4 px-6">{{ employee.workLocation }}</td>
        <td class="py-4 px-6">{{ employee.mobilePhone }}</td>
        <td class="py-4 px-6">{{ employee.email }}</td>
    </tr>
</template>


<script>
export default {
    props: {
        employee: {
            type: Object,
            required: true
        }
    }
}
</script>