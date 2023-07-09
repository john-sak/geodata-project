import React from 'react'
import SignupForm from './SignupForm'
import SignupLogo from './SignupLogo'

const Signup = () => {
  return (
    <div className='relative h-[740px] w-[100%] bg-cyan-200 flex items-center flex-wrap flex-col'>
        <SignupLogo/>
        <SignupForm/>
    </div>
  )
}

export default Signup