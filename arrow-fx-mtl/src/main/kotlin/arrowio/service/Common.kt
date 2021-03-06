package arrowio.service

import arrow.fx.ForIO
import arrow.fx.IO
import arrow.fx.extensions.io.monad.monad
import arrow.mtl.EitherT
import arrow.mtl.EitherTPartialOf
import arrow.mtl.Kleisli
import arrow.mtl.ReaderT
import arrow.mtl.extensions.eithert.monad.monad
import arrow.mtl.extensions.kleisli.monad.monad
import arrowio.repository.AccountRepository

val AccountOperationMonad =
    ReaderT.monad<AccountRepository, EitherTPartialOf<AccountServiceException, ForIO>>(EitherT.monad(IO.monad()))

typealias AccountOperation<A> = Kleisli<AccountRepository, EitherTPartialOf<AccountServiceException, ForIO>, A>