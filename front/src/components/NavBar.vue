<template>
    <nav class="flex justify-between bg-white px-4 py-2.5 fixed w-full z-20 top-0 left-0 border">
        <div class="items-center">
            <img src="favicon.png" class="mr-3 h-9" alt="Helpdesk Logo" />
            <span class="text-xl font-semibold whitespace-nowrap">Helpdesk</span>
        </div>
        <div class="items-center font-medium flex-row space-x-8 mt-0">
            <a href="#" class="selected">Заявки</a>
            <a href="#">Абоненты</a>
            <a href="#">Оборудование</a>
        </div>
        <div>
            <a href="#" class="text-white bg-primary-700 hover:bg-primary-800 focus:ring-4 focus:ring-primary-300 
                font-medium rounded-lg text-sm px-5 py-2.5 mr-2 focus:outline-none">Войти</a>
        </div>
    </nav>
</template>

<script>
export default {
    
}
</script>

<style scoped>
div {
    display: flex;
}

a {
    display: block;
    padding-top: 8px;
    padding-bottom: 8px;
}

a:hover {
    color: rgb(29 78 216);
}

a.selected {
    color: rgb(29 78 216);
}

</style>