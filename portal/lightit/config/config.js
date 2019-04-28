
export default {
    singular: true,
    plugins: [
        ['umi-plugin-react', {
            antd: true,
            dva: true
        }]
    ],
    routes: [
        {   path:"/",
            component: "./demo/layout",

            routes: [
                {
                    path: '/',
                    component: './demo/HelloWorldCard'
                },
                {
                    path: '/pcards',
                    component: './demo/PCardsPage'
                },
                {
                    paht: "/shopping",
                    component: "./demo/Shopping"
                },
                {
                    paht: "/DemoComponent",
                    component: "./demo/DemoComponent"
                },
                {
                    paht: "/DemoTab",
                    component: "./demo/DemoTab"
                }
            ]
        }
    ]
}
