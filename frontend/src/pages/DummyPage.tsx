import React from 'react'
import DummyComponent from '@/components/DummyComponent'
import { InferGetServerSidePropsType } from 'next'

const DummyPage = ({data}: InferGetServerSidePropsType<typeof getServerSideProps>) => {
  return (
    <>  
        <p>
            SSR fetch {data.results[0].email}
        </p>
        <DummyComponent/>
    </>
  )
}

// This gets called on every request
export async function getServerSideProps() {
    // Fetch data from external API
    const res = await fetch(`https://randomuser.me/api/`)
    const data = await res.json();
    console.log(data);
  
    // Pass data to the page via props
    return { props: { data } }
}

export default DummyPage