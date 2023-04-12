import React from 'react'
import Head from 'next/head'
import NavBar from './components/NavBar/NavBar'

interface Props {
    children?: React.ReactNode
}

const Layout = ({children}: Props) => {
  return (
    <>
    <Head>
        <title>
            CrowdCritic
        </title>
    </Head>
    <NavBar/>
    <main>
        {children}
    </main>
    </>
  )
}

export default Layout