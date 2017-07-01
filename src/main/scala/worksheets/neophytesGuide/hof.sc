case class Email(subject : String,
                 body : String,
                 sender : String)



type FilterCriteria = Email => Boolean

def mailsForUser(mails : List[Email], f : FilterCriteria) = mails.filter(f)

val senders = Set("johndoe@example.com")

val sentByOneOf : Set[String] => FilterCriteria =
  senders => email => senders.contains(email.sender)

val mails = List(Email(
  subject = "It's me again, your stalker friend!",
  body = "Hello my friend! How are you?",
  sender = "johndoe@example.com"))


//mailsForUser(mails,sentByOneOf(senders))

type sizeChecker= Int => Boolean

val sizeCriteria : sizeChecker => FilterCriteria =
  f => email => f(email.body.length)

mailsForUser(mails,sizeCriteria(_ > 5))
