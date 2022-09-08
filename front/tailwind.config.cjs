module.exports = {
  content: [
    "./index.html",
    "./src/**/*.{vue,js,ts,jsx,tsx}",  
    "./node_modules/flowbite/**/*.js"  
  ],
  theme: {
    extend: {},
    colors: {
      'completed': '#D9EAD3',
      'grid': '#E2E3E3',
    },    
  },
  plugins: [    
    require('flowbite/plugin')
  ],
}
