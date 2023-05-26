import React from 'react'
import SigninForm from './SigninForm'
import SigninLogo from './SigninLogo'

const Signin = () => {
  return (
    <div className='relative h-[690px] w-[100%] bg-cyan-200 flex items-center flex-wrap flex-col'>
        <SigninLogo/>
        <SigninForm/>
    </div>
  )
}

export default Signin