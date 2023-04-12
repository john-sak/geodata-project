import dynamic from "next/dynamic";

const DummyComponent = dynamic(() => import('./DummyComponent'), {
    ssr: false
})

export default DummyComponent;