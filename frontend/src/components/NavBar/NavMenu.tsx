import React from 'react'
import { INavMenu } from './Inav';
import Link from 'next/link';
import useCloseModal from '@/hooks/useCloseModal';
import useLogged from './useLogged';
import { useRouter } from 'next/router';

const NavMenu = (props: INavMenu) => {

    const { open, setOpen } = props;

    let ref = useCloseModal(() => setOpen(!open));

    const { isLogged, setIsLogged } = useLogged();

    const router = useRouter();

    const handleLogout = () => {
        localStorage.clear();
        setIsLogged(false);
        setOpen(!open);
        router.replace('/');
    }

  return (
    <div className='absolute top-0 right-0 w-44 h-[260px] bg-slate-300 rounded z-9'
    ref={ref}
    >
        <div className='absolute top-[70px] h-[160px] w-44'>
            <div className='h-10 flex justify-center items-center'>
                <Link href={'/search'}
                className='underline text-sky-700'
                onClick={() => setOpen(!open)}
                >
                    Εφαρμογή
                </Link>
            </div>
            <div className='h-10 flex justify-center items-center'>
                <p
                className='underline text-sky-700'
                >
                    Δεδομένα
                </p>
            </div>
            <div className='h-10 flex justify-center items-center'>
                <Link href={isLogged ? '/ProfilePage' : '/SigninPage'}
                onClick={() => setOpen(!open)}
                className='underline text-sky-700'
                >
                    {
                        isLogged ? 
                            'Λογαριασμός' :
                                'Σύνδεση'
                    }
                </Link>
            </div>
            <div className='h-10 flex justify-center items-center'>
                {
                    isLogged ?
                        <p
                        className='underline text-sky-700'
                        onClick={handleLogout}
                        >
                            Αποσύνδεση
                        </p> :
                        <Link href={'/SignupPage'}
                        className='underline text-sky-700'
                        onClick={() => setOpen(!open)}
                        >
                            Εγγραφή
                        </Link>
                }
            </div>
        </div>
    </div>
  )
}

export default NavMenu